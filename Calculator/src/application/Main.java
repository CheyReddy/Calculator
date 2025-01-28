package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root,310,380);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			MainController controller = loader.getController();
			controller.initialize();
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent e) {
					switch(e.getCode()) {
						case  ESCAPE -> {controller.clearBtn(null);break;}
						case  NUMPAD0-> {controller.btn0(null);break;}
						case  NUMPAD1-> {controller.btn1(null);break;}
						case  NUMPAD2-> {controller.btn2(null);break;}
						case  NUMPAD3-> {controller.btn3(null);break;}
						case  NUMPAD4-> {controller.btn4(null);break;}
						case  NUMPAD5-> {controller.btn5(null);break;}
						case  NUMPAD6-> {controller.btn6(null);break;}
						case  NUMPAD7-> {controller.btn7(null);break;}
						case  NUMPAD8-> {controller.btn8(null);break;}
						case  NUMPAD9-> {controller.btn9(null);break;}
						case  DECIMAL-> {controller.btnDot(null);break;}
						case  ADD-> {controller.add(null);break;}
						case  SUBTRACT-> {controller.sub(null);break;}
						case  MULTIPLY-> {controller.mul(null);break;}
						case  DIVIDE-> {controller.div(null);break;}
						case  DIGIT5-> {controller.mod(null);break;}
						case  BACK_SPACE-> {controller.backBtn(null);break;}
						case  ENTER-> {controller.equalBtn(null);break;}
						default -> {break;}
					}
				}
				
			});
			primaryStage.setScene(scene);
			primaryStage.setTitle("Calculator");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
