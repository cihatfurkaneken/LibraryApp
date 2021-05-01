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

import tr.edu.javaodev.dal.KitaplarDAL;
import tr.edu.javaodev.dal.StokDAL;
import tr.edu.javaodev.interfaces.IFeInterfaces;
import tr.edu.javaodev.types.KitapStokContract;
import tr.edu.javaodev.types.KitaplarContract;

public class KitapSilFE extends JDialog implements IFeInterfaces {

	public KitapSilFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		
		add(panel);
		setTitle("Kitap Sil");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(2, 2));

		JLabel kitapSecLabel = new JLabel("Kitap Seç", JLabel.RIGHT);
		panel.add(kitapSecLabel);
		JComboBox kitaplarBox = new JComboBox(new KitaplarDAL().GetAll().toArray());
		panel.add(kitaplarBox);

		JButton silButton = new JButton("Sil");
		panel.add(silButton);
		JButton iptalButton = new JButton("Ýptal");
		panel.add(iptalButton);

		silButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				KitaplarContract contract = new KitaplarContract();
				KitaplarContract kContract = (KitaplarContract) kitaplarBox.getSelectedItem();
				
				KitapStokContract contractS = new KitapStokContract();

				contractS.setKitapId(kContract.getId());

				new StokDAL().Delete(contractS);

				contract.setId(kContract.getId());

				new KitaplarDAL().Delete(contract);

				JOptionPane.showMessageDialog(null, "Silme Ýþlemi Baþarýlý");
						
				
				
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
