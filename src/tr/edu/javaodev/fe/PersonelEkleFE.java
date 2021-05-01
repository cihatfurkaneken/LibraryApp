package tr.edu.javaodev.fe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.edu.javaodev.dal.PersonelDAL;
import tr.edu.javaodev.interfaces.IFeInterfaces;
import tr.edu.javaodev.types.PersonelContract;

public class PersonelEkleFE extends JDialog implements IFeInterfaces{

	public PersonelEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Pesonel Ekle"));
		add(panel);
		setTitle("Personel Ekle");
		pack();
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(3,2));
		JLabel adiSoyadiLabel = new JLabel("Ad Soyad:",JLabel.RIGHT);
		panel.add(adiSoyadiLabel);
		JTextField adiSoyadiField = new JTextField(10);
		panel.add(adiSoyadiField);
		
		JLabel ePostoLabel = new JLabel("Eposta:",JLabel.RIGHT);
		panel.add(ePostoLabel);
		JTextField ePostaField = new JTextField(10);
		panel.add(ePostaField);
		
		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		
		JButton iptalButton = new JButton("Ýptal");
		panel.add(iptalButton);
		
		kaydetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonelContract contract = new PersonelContract();
				contract.setAdiSoyadi(adiSoyadiField.getText());
				contract.setEmail(ePostaField.getText());
				
				new PersonelDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdiSoyadi()+" adlý personel eklenmiþtir.");
				
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
