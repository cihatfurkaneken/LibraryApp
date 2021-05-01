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

import tr.edu.javaodev.dal.UyeDAL;
import tr.edu.javaodev.interfaces.IFeInterfaces;
import tr.edu.javaodev.types.UyeContract;

public class UyeEkleFE extends JDialog implements IFeInterfaces {

	public UyeEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();

		panel.setBorder(BorderFactory.createTitledBorder("Üye Kayýt Alaný"));
		add(panel);
		setTitle("Üye Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(6,2));
		JLabel adiSoyadiLabel = new JLabel("Adý Soyad:",JLabel.RIGHT);
		panel.add(adiSoyadiLabel);
		JTextField adiSoyadField = new JTextField(15);
		panel.add(adiSoyadField);
		JLabel ogrNoLabel = new JLabel("Öðrenci No:",JLabel.RIGHT);
		panel.add(ogrNoLabel);
		JTextField ogrNoField = new JTextField(15);
		panel.add(ogrNoField);
		JLabel ogrFakulteLabel = new JLabel("Fakülte:",JLabel.RIGHT);
		panel.add(ogrFakulteLabel);
		JTextField fakulteField = new JTextField(15);
		panel.add(fakulteField);
		JLabel ogrBolum = new JLabel("Bölüm:",JLabel.RIGHT);
		panel.add(ogrBolum);
		JTextField bolumField = new JTextField(15);
		panel.add(bolumField);
		JLabel ogrSinif = new JLabel("Sýnýf:",JLabel.RIGHT);
		panel.add(ogrSinif);
		JTextField sinifField = new JTextField(15);
		panel.add(sinifField);
		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		JButton iptalButton = new JButton("Ýptal");
		panel.add(iptalButton);
		
		kaydetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UyeContract contract = new UyeContract();
				contract.setAdiSoyadi(adiSoyadField.getText());
				contract.setOgrno(ogrNoField.getText());
				contract.setFakulte(fakulteField.getText());
				contract.setBolum(bolumField.getText());
				contract.setSinif(Integer.parseInt(sinifField.getText()));
				new UyeDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdiSoyadi()+" baþarýyla eklendi.");
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
