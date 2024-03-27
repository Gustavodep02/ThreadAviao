package view;

import java.util.concurrent.Semaphore;

import controller.Decolar;

public class Main {

	public static void main(String[] args) {

		int permissoesPistaNorte = 2;
		int permissoesPistaSul = 2;
		int permissoesDecolarNorte = 1;
		int permissoesDecolarSul = 1;
		Semaphore semaforoPistaNorte = new Semaphore(permissoesPistaNorte);
		Semaphore semaforoPistaSul = new Semaphore(permissoesPistaSul);
		Semaphore semaforoDecolarNorte = new Semaphore(permissoesDecolarNorte);
		Semaphore semaforoDecolarSul = new Semaphore(permissoesDecolarSul);

		for (int i = 0; i < 12; i++) {
			Decolar d = new Decolar(i + 1, 1, semaforoPistaNorte, permissoesDecolarNorte,
					semaforoDecolarNorte,permissoesPistaSul,semaforoPistaSul,permissoesDecolarSul, semaforoDecolarSul);
			d.start();
		}
	}

}
