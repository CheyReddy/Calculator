package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MainController {
	
	@FXML
	private TextField mainDisplay;
	
	@FXML
	private TextField savedNumbers;
	
	private String firstNumber = "";
	
	private String currentNumber = "";
	
	private String calculationMethod;
	
	private double finalNum;
	
	@FXML
	private AnchorPane mainPane;
	
	@FXML
	public void initialize() {
		Platform.runLater(()-> {
			mainPane.requestFocus(); // set focus to a non-button element.
		});
	}
	
	@FXML
	public void add(ActionEvent e) {
		calculation("+");
	}
	@FXML
	public void sub(ActionEvent e) {
		calculation("-");
	}
	@FXML
	public void mul(ActionEvent e) {
		calculation("*");
	}
	@FXML
	public void div(ActionEvent e) {
		calculation("/");
	}
	@FXML
	public void mod(ActionEvent e) {
		calculation("%");
	}
	
	@FXML
	public void btnDot(ActionEvent e) {
			addNum(".");
	}
	@FXML
	public void btn0(ActionEvent e) {
			addNum("0");
	}
	@FXML
	public void btn00(ActionEvent e) {
			addNum("00");
	}
	@FXML
	public void btn1(ActionEvent e) {
		addNum("1");
	}
	@FXML
	public void btn2(ActionEvent e) {
		addNum("2");
	}
	@FXML
	public void btn3(ActionEvent e) {
		addNum("3");
	}
	@FXML
	public void btn4(ActionEvent e) {
		addNum("4");
	}
	@FXML
	public void btn5(ActionEvent e) {
		addNum("5");
	}
	@FXML
	public void btn6(ActionEvent e) {
		addNum("6");
	}
	@FXML
	public void btn7(ActionEvent e) {
		addNum("7");
	}
	@FXML
	public void btn8(ActionEvent e) {
		addNum("8");
	}
	@FXML
	public void btn9(ActionEvent e) {
		addNum("9");
	}
	
	public void calculation(String calculationMethod) {
		this.calculationMethod = calculationMethod;
		firstNumber = currentNumber;
		currentNumber = " ";
		savedNumbers.setText(firstNumber+" "+calculationMethod);
	}
	
	@FXML
	public void equalBtn(ActionEvent e) {
		double firstNum = Double.parseDouble(firstNumber);
		double secondNum = Double.parseDouble(currentNumber);
		
		switch(calculationMethod) {
		case "+" -> {
				finalNum = firstNum+secondNum;
				savedNumbers.setText(firstNumber+" + "+currentNumber+" = ");
				mainDisplay.setText(String.valueOf(finalNum));
			}
		case "-" -> {
				finalNum = firstNum-secondNum;
				savedNumbers.setText(firstNumber+" - "+currentNumber+" = ");
				mainDisplay.setText(String.valueOf(finalNum));
			}
		case "*" -> {
				finalNum = firstNum*secondNum;
				savedNumbers.setText(firstNumber+" * "+currentNumber+" = ");
				mainDisplay.setText(String.valueOf(finalNum));
			}
		case "/" -> {
				finalNum = firstNum/secondNum;
				savedNumbers.setText(firstNumber+" / "+currentNumber+" = ");
				mainDisplay.setText(String.valueOf(finalNum));
			}
		case "%" -> {
				finalNum = firstNum%secondNum;
				savedNumbers.setText(firstNumber+" % "+currentNumber+" = ");
				mainDisplay.setText(String.valueOf(finalNum));
			}
		case "" -> {
				savedNumbers.setText("");
				mainDisplay.setText("");
			}
		}
		currentNumber = String.valueOf(finalNum);
	}
	
	@FXML
	public void backBtn(ActionEvent e) {
		currentNumber = currentNumber.substring(0, currentNumber.length()-1);
		savedNumbers.setText(currentNumber);
		mainDisplay.setText(currentNumber);
	}
	@FXML
	public void clearBtn(ActionEvent e) {
		currentNumber = "";
		mainDisplay.setText("");
		savedNumbers.setText("");
	}
	
	public void addNum(String num) {
		currentNumber += num;
		updateNum();
	}
	
	public void updateNum() {
		mainDisplay.setText(currentNumber);
	}

}
