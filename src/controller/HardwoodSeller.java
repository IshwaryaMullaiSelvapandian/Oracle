package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import model.WoodItem;

/**
 * @author Ishwarya Mullai Selvapandian
 * 
 */

public class HardwoodSeller {

	/**
	 * @param args
	 * @throws IOException
	 */
	WoodItem w = null;

	BufferedReader br = null;
	public static ArrayList<Double> delveryTimeList = new ArrayList<Double>();
	public double totalPrice;

	String value, valarr[];
	double quantity, amountTypeVal, calValue, itemPrice;

	/**
	 * 
	 * @param inputFilePath
	 * @throws IOException
	 */
	public void readInputFile(String inputFilePath) throws IOException {
		w = new WoodItem();
		br = new BufferedReader(new FileReader(inputFilePath));
		String sCurrentLine;
		String arr[] = null, arr1[] = null;

		while ((sCurrentLine = br.readLine()) != null) {
			totalPrice = 0.0;
			delveryTimeList.clear();
			arr = sCurrentLine.split(";");

			if (arr.length == 3 && !sCurrentLine.contains(":")) {

				w.setName(arr[0]);
				w.setAddress(arr[1]);
				w.setDate(arr[2]);
				System.out.println("Name of the Buyer: " + w.getName() + "\n"
						+ "Address of Delivery: " + w.getAddress() + "\n"
						+ "Purchased Date: " + w.getDate());

			}

			else {
				System.out.println("List of Ordered Wood: ");
				for (int i = 0; i < arr.length; i++) {
					arr1 = arr[i].split(":");
					value = woodItemType(arr1[0]);
					valarr = value.split(":");
					quantity = Double.parseDouble(arr1[1]);
					amountTypeVal = quantityType(quantity);

					calValue = Double.parseDouble(valarr[0]) * amountTypeVal;
					delveryTimeList.add(calValue);
					double itemPrice = quantity * Double.parseDouble(valarr[1]);
					totalPrice += itemPrice;

					w.setType(arr1[0]);
					w.setQuantity(quantity);
					w.setPriceOfEachItem(itemPrice);

					System.out.println("Hardwood Type: " + w.getType() + "  "
							+ "BF Purchased: " + w.getQuantity() + "  "
							+ "Price: " + w.getPriceOfEachItem());

				}

				w.setTotalPrice(totalPrice);
				w.setMaxDeliverytime(deliveryTime());
				System.out.println(w);

			}
		}
	}

	/**
	 * 
	 * @param quantity
	 * @return
	 */
	public double quantityType(double quantity) {
		double quantityTypeVal = 0;
		if (quantity >= 1 && quantity <= 100) {
			quantityTypeVal = 1;
		} else if (quantity >= 101 && quantity <= 200) {
			quantityTypeVal = 2;
		} else if (quantity >= 201 && quantity <= 300) {
			quantityTypeVal = 3;
		} else if (quantity >= 301 && quantity <= 400) {
			quantityTypeVal = 4;
		} else if (quantity >= 401 && quantity <= 500) {
			quantityTypeVal = 5;
		} else if (quantity >= 501 && quantity <= 1000) {
			quantityTypeVal = 5.5;
		}
		return quantityTypeVal;

	}

	/**
	 * 
	 * @param hardwoodType
	 * @return
	 */
	public String woodItemType(String hardwoodType) {

		double baseDeliveryTime = 0.0;
		double pricePerBoardFoot = 0.0;
		if (hardwoodType.equalsIgnoreCase("cherry")) {
			baseDeliveryTime = 2.5;
			pricePerBoardFoot = 5.95;
		} else if (hardwoodType.equalsIgnoreCase("Curly Maple")) {
			baseDeliveryTime = 1.5;
			pricePerBoardFoot = 6.00;
		} else if (hardwoodType.equalsIgnoreCase("Genuine Mahogany")) {
			baseDeliveryTime = 3;
			pricePerBoardFoot = 9.60;
		} else if (hardwoodType.equalsIgnoreCase("Wenge")) {
			baseDeliveryTime = 5;
			pricePerBoardFoot = 22.35;
		} else if (hardwoodType.equalsIgnoreCase("White Oak")) {
			baseDeliveryTime = 2.3;
			pricePerBoardFoot = 6.70;
		} else if (hardwoodType.equalsIgnoreCase("Sawdust")) {
			baseDeliveryTime = 1;
			pricePerBoardFoot = 1.5;
		}
		return baseDeliveryTime + ":" + pricePerBoardFoot;
	}

	public Double deliveryTime() {
		double deliveryETA = 0.0;
		deliveryETA = Collections.max(delveryTimeList);

		return deliveryETA;
	}

	public static void main(String[] args) throws IOException {
		HardwoodSeller obj = new HardwoodSeller();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Input File Path");
		String inPath = sc.next();
		obj.readInputFile(inPath);

	}

}