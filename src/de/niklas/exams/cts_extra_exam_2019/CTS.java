package de.niklas.exams.cts_extra_exam_2019;
import java.nio.file.*;
import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Certificate Trade Simulator
 */
public class CTS {

	public static void main(final String[] args) {
		final List<Company> companies = CTS.loadCompanies();

		final StockExchangeTerm stockExchange = new StockExchangeTerm();

		for (final Company c : companies) {
			stockExchange.registerCompanyTerm(new CompanyTerm(c, stockExchange));
		}

	}

	public static List<Company> loadCompanies() {
		final List<Company> companies = new LinkedList<>();

		String filename = "src/de/niklas/exams/cts_extra_exam_2019/companies.txt";
		try {
		    Files.readAllLines(Paths.get(filename)) // als Stream weiterverarbeiten
		            .forEach(line -> companies.add(parseCompany(line))); // z.B.
		} catch (NumberFormatException | IOException ex) {
		    System.err.printf("Read error: %s%n", ex.getLocalizedMessage());
		}

		final List<Company> shortCompanies = new LinkedList<>();
		for(int i = 0; i < 2; i++){
			int rand = new Random().nextInt(0, companies.size());
			shortCompanies.add(companies.get(rand));
			companies.remove(rand);
		}

		return shortCompanies;
	}

	private static Company parseCompany(final String line) {
		final String[] lineArr = line.split("[;]");
		return new Company(lineArr[0], lineArr[1], lineArr[2]);
	}

}
