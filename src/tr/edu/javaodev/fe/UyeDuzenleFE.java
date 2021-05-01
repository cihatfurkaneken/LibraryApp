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

import tr.edu.javaodev.dal.UyeDAL;
import tr.edu.javaodev.interfaces.IFeInterfaces;
import tr.edu.javaodev.types.UyeContract;

public class UyeDuzenleFE extends JDialog implements IFeInterfaces {

	public UyeDuzenleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();

		panel.setBorder(BorderFactory.createTitledBorder("Uye D�zenleme Ekran�"));
		add(panel);
		setTitle("Uye D�zenle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(7, 2));
		
		JLabel uyeBoxLabel = new JLabel("�ye Se�:",JLabel.RIGHT);
		panel.add(uyeBoxLabel);
		JComboBox uyeBox = new JComboBox(new UyeDAL().GetAll().toArray());
		panel.add(uyeBox);
		
		JLabel adiLabel = new JLabel("�ye Ad� Soyad�:",JLabel.RIGHT);
		panel.add(adiLabel);
		JTextField adiSoyadiField = new JTextField(20);
		panel.add(adiSoyadiField);
		
		JLabel ogrNoLabel = new JLabel("�ye No:",JLabel.RIGHT);
		panel.add(ogrNoLabel);
		JTextField ogrNoField = new JTextField(20);
		panel.add(ogrNoField);
		
		JLabel fakulteLabel = new JLabel("�ye Fak�ltesi:",JLabel.RIGHT);
		panel.add(fakulteLabel);
		JTextField fakulteField = new JTextField(20);
		panel.add(fakulteField);
		
		JLabel bolumLabel = new JLabel("�ye B�l�m�:",JLabel.RIGHT);
		panel.add(bolumLabel);
		JTextField bolumField = new JTextField(20);
		panel.add(bolumField);
		
		JLabel sinifLabel = new JLabel("�ye S�n�f��:",JLabel.RIGHT);
		panel.add(sinifLabel);
		JTextField sinifField = new JTextField(10);
		panel.add(sinifField);
		
		
		uyeBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UyeContract contract = (UyeContract) uyeBox.getSelectedItem();
				
				adiSoyadiField.setText(contract.getAdiSoyadi());
				ogrNoField.setText(contract.getOgrno());
				fakulteField.setText(contract.getFakulte());
				bolumField.setText(contract.getBolum());
				sinifField.setText(String.valueOf(contract.getSinif()));
				
			}
			
		});
		
		
		JButton duzenleButton = new JButton("D�zenle");
		panel.add(duzenleButton);
		
		duzenleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UyeContract contract = new UyeContract();
				UyeContract sContract = (UyeContract) uyeBox.getSelectedItem();
				
				contract.setAdiSoyadi(adiSoyadiField.getText());
				contract.setOgrno(ogrNoField.getText());
				contract.setFakulte(fakulteField.getText());
				contract.setBolum(bolumField.getText());
				contract.setSinif(Integer.parseInt(sinifField.getText()));
				
				contract.setId(sContract.getId());
				
				new UyeDAL().Update(contract);

				JOptionPane.showMessageDialog(null, contract.getAdiSoyadi()+" adl� uye d�zenlenmi�tir.");
				
				
			}
			
		});
		
		JButton iptalButton = new JButton("�ptal");
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
