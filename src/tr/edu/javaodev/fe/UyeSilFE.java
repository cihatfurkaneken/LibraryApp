package tr.edu.javaodev.fe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import tr.edu.javaodev.dal.UyeDAL;
import tr.edu.javaodev.interfaces.IFeInterfaces;
import tr.edu.javaodev.types.UyeContract;

public class UyeSilFE extends JDialog implements IFeInterfaces {

	public UyeSilFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		add(panel);
		setTitle("Üye Sil");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(2,2));
		JLabel uyeSecLabel = new JLabel("Üye Seç",JLabel.RIGHT);
		panel.add(uyeSecLabel);
		JComboBox uyeBox = new JComboBox(new UyeDAL().GetAll().toArray());
		panel.add(uyeBox);
		
		JButton silButton = new JButton("Sil");
		panel.add(silButton);
		JButton iptalButton = new JButton("Ýptal");
		panel.add(iptalButton);
		
		silButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UyeContract contract = new UyeContract();
				UyeContract pContract = (UyeContract) uyeBox.getSelectedItem();
				
				contract.setId(pContract.getId());
				
				new UyeDAL().Delete(contract);
				

				JOptionPane.showMessageDialog(null,"Silme Ýþlemi Baþarýlý");
				
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
