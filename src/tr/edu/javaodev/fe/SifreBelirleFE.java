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

import tr.edu.javaodev.dal.AccountsDAL;
import tr.edu.javaodev.dal.PersonelDAL;
import tr.edu.javaodev.dal.YetkilerDAL;
import tr.edu.javaodev.interfaces.IFeInterfaces;
import tr.edu.javaodev.types.PersonelContract;
import tr.edu.javaodev.types.Yetkiler;

public class SifreBelirleFE  extends JDialog implements IFeInterfaces{

	public SifreBelirleFE() {
		
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Þifre Ekle"));
		add(panel);
		setTitle("Þifre Belirleme Ýþlemleri");
		pack();
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		
		JPanel panel = new JPanel(new GridLayout(5,2));
		JLabel personelLabel = new JLabel("Personel Seç:",JLabel.RIGHT);
		panel.add(personelLabel);
		JComboBox personelBox = new JComboBox(new PersonelDAL().GetAll().toArray());
		panel.add(personelBox);
		JLabel yetkiLabel = new JLabel("Yetki Seç:",JLabel.RIGHT);
		panel.add(yetkiLabel);
		JComboBox yetkiBox = new JComboBox(new YetkilerDAL().GetAll().toArray());
		panel.add(yetkiBox);
		JLabel passwordLabel = new JLabel("Þifre Belirle",JLabel.RIGHT);
		panel.add(passwordLabel);
		JPasswordField pass1Field = new JPasswordField(10);
		panel.add(pass1Field);
		JLabel passTekrarLabel = new JLabel("Tekrar Gir",JLabel.RIGHT);
		panel.add(passTekrarLabel);
		JPasswordField passTekrar = new JPasswordField(10);
		panel.add(passTekrar);
		
		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		JButton iptalButton = new JButton("Ýptal ");
		panel.add(iptalButton);
		
		kaydetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PersonelContract innerContract = new PersonelContract();
				PersonelContract.AccountsContract contract =  innerContract.new AccountsContract(); 
				PersonelContract pContract = (PersonelContract) personelBox.getSelectedItem();
				Yetkiler yContract = (Yetkiler) yetkiBox.getSelectedItem();
				if(pass1Field.getText().equals(passTekrar.getText())) {
					contract.setPersonelId(pContract.getId());
					contract.setYetkiId(yContract.getId());
					contract.setSifre(pass1Field.getText());
					
					new AccountsDAL().Insert(contract);

					JOptionPane.showMessageDialog(null, pContract.getAdiSoyadi()+" adli kiþiye "+yContract.getAdi()+" yetkisi Baþarýyla Kayýt Edildi");
				}
				else {
					JOptionPane.showMessageDialog(null, "Þifreler Ayný Deðil !");
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
