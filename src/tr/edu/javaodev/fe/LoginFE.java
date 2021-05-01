package tr.edu.javaodev.fe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import tr.edu.javaodev.dal.AccountsDAL;
import tr.edu.javaodev.dal.PersonelDAL;
import tr.edu.javaodev.interfaces.IFeInterfaces;
import tr.edu.javaodev.types.PersonelContract;

public class LoginFE extends JDialog implements IFeInterfaces {

	public static JComboBox emailBox;

	public LoginFE() {
		initPencere();
	}

	@Override
	public void initPencere() {

		JPanel panel = initPanel();
		setTitle("Lütfen Giriþ Yapýnýz.");
		panel.setBorder(BorderFactory.createTitledBorder("Giriþ Yap"));
		add(panel);
		setTitle("Giriþ Yap");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(3, 2));

		JLabel emailLabel = new JLabel("Email", JLabel.RIGHT);
		panel.add(emailLabel);
		emailBox = new JComboBox(new PersonelDAL().GetAll().toArray());
		panel.add(emailBox);
		JLabel passwordLabel = new JLabel("Þifre:", JLabel.RIGHT);
		panel.add(passwordLabel);
		JPasswordField passwordField = new JPasswordField(15);
		panel.add(passwordField);

		JButton loginButton = new JButton("Giriþ Yap");
		panel.add(loginButton);
		JButton iptalButton = new JButton("Ýptal");
		panel.add(iptalButton);

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonelContract contract = (PersonelContract) emailBox.getSelectedItem();
				if (new AccountsDAL().GetPersonelIdveSifre(contract.getId(), passwordField.getText()).getId() != 0) {

					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							new AnaPencereFE();
							/* new AnaPencereFE(); */
						}
					});

					dispose();

				} else if (contract.getId() == 2) {
					new KitapAlmaFE();
				} else {
					JOptionPane.showMessageDialog(null, "Giriþ Baþarýsýz");
				}

			}
		});

		return panel;
	}

	@Override
	public JMenuBar initBar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTabbedPane initTabs() {
		// TODO Auto-generated method stub
		return null;
	}

}
