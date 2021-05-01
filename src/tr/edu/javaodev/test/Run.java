package tr.edu.javaodev.test;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import tr.edu.javaodev.fe.LoginFE;

public class Run {

	public static void main(String[] args) {
		try {
			for(LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()) {
				UIManager.setLookAndFeel(info.getClassName());
				break;
			}
		}catch(Exception e) {
			
		}
		SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			new LoginFE();
			/*new AnaPencereFE();*/
		}
		});;
	}

}
