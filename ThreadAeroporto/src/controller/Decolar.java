package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Decolar extends Thread {
	private int permissoesPistaNorte;
	private int permissoesPistaSul;
	private int permissoesDecolarNorte;
	private int permissoesDecolarSul;
	private int id;
	Random random = new Random();
	Semaphore semaforoPistaNorte = new Semaphore(permissoesPistaNorte);
	Semaphore semaforoPistaSul = new Semaphore(permissoesPistaSul);
	Semaphore semaforoDecolarNorte = new Semaphore(permissoesDecolarNorte);
	Semaphore semaforoDecolarSul = new Semaphore(permissoesDecolarSul);

	public Decolar(int id, int permissoesPistaNorte, Semaphore semaforoPistaNorte, int permissoesDecolarNorte, // id,
																												// permpn,sempn,permdn,semdn,permps,
																												// semps,
																												// permpds,
																												// semds
			Semaphore semaforoDecolarNorte, int permissoesPistaSul, Semaphore semaforoPistaSul,
			int permissoesDecolarSul, Semaphore semaforoDecolarSul) {
		this.permissoesPistaNorte = permissoesPistaNorte;
		this.semaforoPistaNorte = semaforoPistaNorte;
		this.permissoesPistaSul = permissoesPistaSul;
		this.semaforoPistaSul = semaforoPistaSul;
		this.permissoesDecolarNorte = permissoesDecolarNorte;
		this.semaforoDecolarNorte = semaforoDecolarNorte;
		this.permissoesDecolarSul = permissoesDecolarSul;
		this.semaforoDecolarSul = semaforoDecolarSul;
		this.id = id;
	}

	public void run() {
		int pista = (int) (Math.random() * 2);

		if (pista == 0) {
			try {
				semaforoPistaNorte.acquire();
				System.out.println("Avião " + id + " está na pista norte");
				pistaNorte();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				semaforoPistaNorte.release();
			}

		} else {
			try {
				semaforoPistaSul.acquire();
				System.out.println("Avião " + id + " está na pista sul");
				pistaSul();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				semaforoPistaSul.release();
			}
		}

	}

	public void pistaNorte() {
		try {
			semaforoDecolarNorte.acquire();
			decolarNorte();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforoDecolarNorte.release();
		}

	}

	public void pistaSul() {
		try {
			semaforoDecolarSul.acquire();
			decolarSul();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforoDecolarSul.release();
		}

	}

	public void decolarNorte() {
		int num = (int) (Math.random() * 401) + 300;
		try {
			Thread.sleep(num);
			System.out.println("Avião " + id + " está manobrando");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num = (int) (Math.random() * 501) + 500;
		try {
			Thread.sleep(num);
			System.out.println("Avião " + id + " está taxiando");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num = (int) (Math.random() * 201) + 600;
		try {
			Thread.sleep(num);
			System.out.println("Avião " + id + " está decolando");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num = (int) (Math.random() * 501) + 300;
		try {
			Thread.sleep(num);
			System.out.println("Avião " + id + " está se afastando da área");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Avião " + id + " decolou");
	}

	public void decolarSul() {
		int num = (int) (Math.random() * 401) + 300;
		try {
			Thread.sleep(num);
			System.out.println("Avião " + id + " está manobrando");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num = (int) (Math.random() * 501) + 500;
		try {
			Thread.sleep(num);
			System.out.println("Avião " + id + " está taxiando");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num = (int) (Math.random() * 201) + 600;
		try {
			Thread.sleep(num);
			System.out.println("Avião " + id + " está decolando");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num = (int) (Math.random() * 501) + 300;
		try {
			Thread.sleep(num);
			System.out.println("Avião " + id + " está se afastando da área");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Avião " + id + " decolou");
	}
}
