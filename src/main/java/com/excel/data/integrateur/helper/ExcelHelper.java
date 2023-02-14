package com.excel.data.integrateur.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.excel.data.integrateur.model.User;

/**
 * @author Said Z'BIRI
 *
 */
public class ExcelHelper {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	/**
	 * @param file
	 * @return true s'il s'agit d'un fichier xlsx sinon false
	 */
	public static boolean hasExcelFormat(File file) {

		try {
			if (!TYPE.equals(Files.probeContentType(file.toPath()))) {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	/**
	 * cette méthode permet de lire les données de chaque colonne du fichier xlsx et
	 * les stocker dans l'objet User
	 * 
	 * @param file
	 * @return une liste de l'objet user
	 */
	public static List<User> excelToUsers(File file) {
		try {
			Workbook workbook = WorkbookFactory.create(file);

			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();

			List<User> users = new ArrayList<User>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				User user = new User();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {
					case 0:
						user.setPrenom(currentCell.getStringCellValue());
						break;

					case 1:
						user.setNom(currentCell.getStringCellValue());
						break;

					case 2:
						user.setDate(currentCell.getDateCellValue());
						break;

					case 3:
						user.setCommentaire(currentCell.getStringCellValue());
						break;

					default:
						break;
					}

					cellIdx++;
				}

				users.add(user);
			}

			workbook.close();

			return users;

		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}

}
