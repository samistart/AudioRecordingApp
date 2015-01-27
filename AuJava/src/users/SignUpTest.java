package users;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * part of login/sign up library from  <a href="http://www.zentut.com/java-swing/simple-login-dialog/">zentut.com</a> 
 * not implemented due to refactoring.
 * 
 * @author Pietro Passarelli 
 *
 */
public class SignUpTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 final JFrame frame = new JFrame("Sign Up Demo");
	        final JButton btnSignUp = new JButton("Sign Up");
	 
	        btnSignUp.addActionListener(
	                new ActionListener(){
	                    public void actionPerformed(ActionEvent e) {
	                        SignUpDialog signUpDialog = new SignUpDialog(frame);
	                        signUpDialog.setVisible(true);
	                        // SignUp successfully
	                        if(signUpDialog.isSucceeded()){
	                        	btnSignUp.setText("Hi " + signUpDialog.getUsername() + "!");
	                        }
	                    }
	                });
	 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(300, 100);
	        frame.setLayout(new FlowLayout());
	        frame.getContentPane().add(btnSignUp);
	        frame.setVisible(true);
	}

}
