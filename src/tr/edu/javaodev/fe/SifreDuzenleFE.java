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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.edu.javaodev.dal.AccountsDAL;
import tr.edu.javaodev.dal.PersonelDAL;
import tr.edu.javaodev.interfaces.IFeInterfaces;
import tr.edu.javaodev.types.PersonelContract;

public class SifreDuzenleFE extends JDialog implements IFeInterfaces {

	public SifreDuzenleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();

		panel.setBorder(BorderFactory.createTitledBorder("Þifre Düzenleme Ekraný"));
		add(panel);
		setTitle("Þifre Düzenle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel(new GridLayout(3, 2));
		JLabel personelAdiLabel = new JLabel("Personel Seç.", JLabel.RIGHT);
		panel.add(personelAdiLabel);
		JComboBox personellerBox = new JComboBox(new PersonelDAL().GetAll().toArray());
		panel.add(personellerBox);
		JLabel personelSifreLabel = new JLabel("Yeni Þifre:",JLabel.RIGHT);
		panel.add(personelSifreLabel);
		JTextField yeniSifreField = new JTextField(10);
		panel.add(yeniSifreField);
			
		
		JButton guncelleButton = new JButton("Güncelle");
		panel.add(guncelleButton);
		
		guncelleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PersonelContract innerContract = new PersonelContract();
				PersonelContract.AccountsContract contract =  innerContract.new AccountsContract(); 
				PersonelContract pContract = (PersonelContract) personellerBox.getSelectedItem();
				contract.setPersonelId(pContract.getId());
				contract.setSifre(yeniSifreField.getText());
			
				
				new AccountsDAL().Update(contract);
				JOptionPane.showMessageDialog(null, pContract.getAdiSoyadi()+" adlý personelin þifresi düzenlenmiþtir.");
			
			}
			
		});
		
		JButton iptalButton = new JButton("Ýptal");
		panel.add(iptalButton);
		
		
		
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
