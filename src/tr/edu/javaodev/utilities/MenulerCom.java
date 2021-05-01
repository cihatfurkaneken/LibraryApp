package tr.edu.javaodev.utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import tr.edu.javaodev.dal.AccountsDAL;
import tr.edu.javaodev.fe.KategoriAraFE;
import tr.edu.javaodev.fe.KategoriEkleFE;
import tr.edu.javaodev.fe.KitapDuzenleFE;
import tr.edu.javaodev.fe.KitapEkleFE;
import tr.edu.javaodev.fe.KitapSilFE;
import tr.edu.javaodev.fe.LoginFE;
import tr.edu.javaodev.fe.PersonelEkleFE;
import tr.edu.javaodev.fe.PersonelSilFE;
import tr.edu.javaodev.fe.SifreBelirleFE;
import tr.edu.javaodev.fe.SifreDuzenleFE;
import tr.edu.javaodev.fe.UyeDuzenleFE;
import tr.edu.javaodev.fe.UyeEkleFE;
import tr.edu.javaodev.fe.UyeSilFE;
import tr.edu.javaodev.fe.YetkiDuzenleFE;
import tr.edu.javaodev.fe.YetkiEkleFE;
import tr.edu.javaodev.types.PersonelContract;

public class MenulerCom {
	public static JMenuBar initBar() {
		JMenuBar bar = new JMenuBar();

		JMenu dosyaMenu = new JMenu("Dosya");
		bar.add(dosyaMenu);
		JMenuItem cikisItem = new JMenuItem("Çýkýþ");
		dosyaMenu.add(cikisItem);
		/* Kitaplar Menüsü */
		JMenu kitaplarMenu = new JMenu("Kitaplar");
		bar.add(kitaplarMenu);
		JMenuItem kitapEkleItem = new JMenuItem("Kitap Ekle");
		kitaplarMenu.add(kitapEkleItem);
		JMenuItem kategoriEkleItem = new JMenuItem("Kategori Ekle");
		kitaplarMenu.add(kategoriEkleItem);
		kitaplarMenu.addSeparator();
		JMenuItem kitapDuzenleItem = new JMenuItem("Kitap Düzenle");
		kitaplarMenu.add(kitapDuzenleItem);
		JMenuItem kategoriDuzenleItem = new JMenuItem("Kategori Ara");
		kitaplarMenu.add(kategoriDuzenleItem);
		kitaplarMenu.addSeparator();
		JMenuItem kitapSilItem = new JMenuItem("Kitap Sil");
		kitaplarMenu.add(kitapSilItem);
		
		/* Personel Menüsü */
		JMenu personellerMenu = new JMenu("Personel Ýþlemleri");
		bar.add(personellerMenu);
		JMenuItem personelEkleItem = new JMenuItem("Personel Ekle");
		personellerMenu.add(personelEkleItem);
		JMenuItem yetkiEkleItem = new JMenuItem("Yetki Ekle");
		personellerMenu.add(yetkiEkleItem);
		JMenuItem sifreBelirleItem = new JMenuItem("Þifre Belirle");
		personellerMenu.add(sifreBelirleItem);
		personellerMenu.addSeparator();

		JMenuItem personelSilItem = new JMenuItem("Personel Sil");
		personellerMenu.add(personelSilItem);
		JMenuItem yetkiDuzenle = new JMenuItem("Yetki Düzenle");
		personellerMenu.add(yetkiDuzenle);
		JMenuItem sifreDuzenlemeItem = new JMenuItem("Þifre Düzenle");
		personellerMenu.add(sifreDuzenlemeItem);
		/* Üyeler Menüsü */
		JMenu uyelerMenusu = new JMenu("Üye Ýþlemleri");
		bar.add(uyelerMenusu);
		JMenuItem uyeEkleItem = new JMenuItem("Üye Ekle");
		uyelerMenusu.add(uyeEkleItem);
		uyelerMenusu.addSeparator();
		JMenuItem uyeDuzenleItem = new JMenuItem("Üye Düzenle");
		uyelerMenusu.add(uyeDuzenleItem);
		uyelerMenusu.addSeparator();
		JMenuItem uyeSilItem = new JMenuItem("Üye Sil");
		uyelerMenusu.add(uyeSilItem);
		
		uyeSilItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new UyeSilFE();
					}
				});
			}
		});
		
		
		personelSilItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new PersonelSilFE();
					}
				});
			}
		});
		
		
		
		kitapSilItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new KitapSilFE();
					}
				});
			}
		});
		
		
		
		cikisItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						System.exit(0);
					}
				});
			}
		});
		
		
		
		PersonelContract contract = (PersonelContract) LoginFE.emailBox.getSelectedItem();
		
		if(new AccountsDAL().GetYetkiId(contract.getId()).getYetkiId()==2) {
			personellerMenu.hide();
		}
		
		
		uyeDuzenleItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new UyeDuzenleFE();
					}
				});
			}
		});
		
		
		sifreDuzenlemeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new SifreDuzenleFE();
					}
				});
			}
		});
		
		kitapDuzenleItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new KitapDuzenleFE();
					}
				});
			}
		});
		kategoriDuzenleItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new KategoriAraFE();
					}
				});
			}
		});
		
		kitapEkleItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new KitapEkleFE();
					}
				});
			}
		});

		kategoriEkleItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new KategoriEkleFE();
			}
		});

		personelEkleItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new PersonelEkleFE();

					}
				});
			}
		});

		yetkiEkleItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new YetkiEkleFE();
					}

				});
			}
		});
		
		yetkiDuzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new YetkiDuzenleFE();
					}

				});
			}
		});
		
		sifreBelirleItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SifreBelirleFE();
			}
			
		});
		
		uyeEkleItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new UyeEkleFE();
					}
				});
				
			}
		});
		return bar;
	}
}
