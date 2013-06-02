package com.qwi.josemi.ticketsRestaurant.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qwi.josemi.ticketsRestaurant.domain.UserDocument;
import com.qwi.josemi.ticketsRestaurant.dto.Movement;
import com.qwi.josemi.ticketsRestaurant.dto.UserData;
import com.qwi.josemi.ticketsRestaurant.repository.UserRepository;

@RequestMapping("/robotController")
@Controller
public class RobotController {

	private Logger logger=LoggerFactory.getLogger(RobotController.class);
	@Autowired UserRepository userRepository;
	
	@RequestMapping("getData")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void getData(@RequestParam String username, @RequestParam String password, @RequestParam String date,
			HttpServletResponse response) throws Exception{
		logger.info(username+"->"+password+"-"+date);
		UserDocument userDocument=userRepository.findByUsername(username);
		logger.info("User found:"+userDocument);
		if (userDocument == null) {
			userDocument=new UserDocument();
			userDocument.setUsername(username);
			userDocument.setAccessNumber(1);
		}
		else userDocument.setAccessNumber(userDocument.getAccessNumber()+1);
		ObjectMapper mapper=new ObjectMapper();
		UserData userData=new UserData();
		WebDriver driver=new HtmlUnitDriver(true);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://clientes.edenred.es/");
		WebElement usernameInput=driver.findElement(By.id("username"));
		WebElement passwordInput=driver.findElement(By.id("Password"));
		WebElement submitBtn=driver.findElement(By.xpath("//button[@type='submit']"));
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		submitBtn.click();
		//Secret date
		WebElement secretDateDiv=driver.findElement(By.id("secret-date"));
		Thread.sleep(3000);
		List<WebElement> secretDateInputs=secretDateDiv.findElements(By.xpath("input[@type='password']"));
		int pos=0;
		for (WebElement secretDateInput:secretDateInputs){
			logger.info(secretDateInput.getAttribute("id")+"=>"+secretDateInput.isDisplayed());
			if (secretDateInput.isDisplayed()){
				secretDateInput.sendKeys(date.substring(pos, pos+1));
			}
			pos++;
		}
		WebElement initiateSessionBtn=driver.findElement(By.xpath("//button[text()='Iniciar Sesión']"));
		initiateSessionBtn.click();
		logger.info("Retrieved "+secretDateInputs.size()+" elements");
		//Current amount
		WebElement currentAmount=driver.findElement(By.xpath("//p[contains(@class, 'current-amount')]/a"));
		userData.setAmount(currentAmount.getText());
		//Username
		WebElement name=driver.findElement(By.xpath("//div[@class='user-area']/strong"));
		userData.setUsername(name.getText());
		//Movements
		driver.findElement(By.xpath("//a[contains(@href, 'saldo')]")).click();
		WebElement movementsTable=driver.findElement(By.xpath("//table[contains(@id, 'tblResults')]"));
		List<WebElement> movementTrList=movementsTable.findElements(By.xpath("tbody/tr"));
		logger.info("Retrieved "+movementTrList.size()+" movements");
		List<Movement> movements=new ArrayList<Movement>();
		for (WebElement movementTr:movementTrList){
			Movement movement=new Movement();
			movement.setDate(movementTr.findElement(By.xpath("td[1]")).getText());
			movement.setConcept(movementTr.findElement(By.xpath("td[2]")).getText());
			movement.setAmount(movementTr.findElement(By.xpath("td[3]")).getText());
			movements.add(movement);
		}
		userData.setMovements(movements);
		driver.close();
		userDocument.setBalance(userData.getAmount());
		userDocument.setMovements(userData.getMovements());
		userRepository.save(userDocument);
		mapper.writeValue(response.getOutputStream(), userData);
	}
}
