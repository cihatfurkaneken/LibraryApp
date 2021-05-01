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

import tr.edu.javaodev.dal.PersonelDAL;
import tr.edu.javaodev.dal.YetkilerDAL;
import tr.edu.javaodev.interfaces.IFeInterfaces;
import tr.edu.javaodev.types.PersonelContract;
import tr.edu.javaodev.types.Yetkiler;

public class YetkiDuzenleFE extends JDialog implements IFeInterfaces{

	public YetkiDuzenleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();

		panel.setBorder(BorderFactory.createTitledBorder("Yetki Düzenleme Ekraný"));
		add(panel);
		setTitle("Yetki Düzenle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(3,2));
		JLabel personelAdiLabel = new JLabel("Yetkili Adi",JLabel.RIGHT);
		panel.add(personelAdiLabel);
		JComboBox personelAdiBox = new JComboBox(new PersonelDAL().GetAll().toArray());
		panel.add(personelAdiBox);
		JLabel personelYetkiLabel = new JLabel("Yetkisi:",JLabel.RIGHT);
		panel.add(personelYetkiLabel);
		JComboBox personelYetkisiBox = new JComboBox(new YetkilerDAL().GetAll().toArray());
		panel.add(personelYetkisiBox);
		
		
		
		
		JButton duzenleButton = new JButton("Düzenle");
		panel.add(duzenleButton);
		
		duzenleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PersonelContract contract = new PersonelContract();
				PersonelContract.PersonelInnerContract personelInner = contract.new PersonelInnerContract();
				PersonelContract pContract = (PersonelContract) personelAdiBox.getSelectedItem();
				Yetkiler yContract = (Yetkiler) personelYetkisiBox.getSelectedItem();
				
				contract.setAdiSoyadi(pContract.getAdiSoyadi());
				personelInner.setYetkiId(yContract.getId());
				contract.setId(pContract.getId());
				
				
				new PersonelDAL().Update(personelInner, contract);
				

				JOptionPane.showMessageDialog(null, pContract.getAdiSoyadi()+" adlý personel görevi düzenlenmiþtir.");
			
				
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
