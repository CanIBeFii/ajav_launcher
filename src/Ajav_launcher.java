import java.io.File;
import java.util.Scanner;

public class Ajav_launcher {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Please give only the input file!");
		}
		try {
			File file = verifyFile(args[0]);
			Simulation simulation = createSimulation(file);
			simulation.runSimulation();

		} catch (Exception e) {
			System.out.println("Error occured: " + e.toString());
			e.printStackTrace();
		}

	}

	private static File verifyFile(String filename) throws Exception{
		File file = new File(filename);
		if (!file.exists()) {
			throw new Exception("File does not exist!");
		}
		if (!file.canRead()) {
			throw new Exception("Cannot read from file!");
		}
		return file;
	}

	private static Simulation createSimulation(File file) throws Exception {
		Scanner scanner = new Scanner(file);
		Integer times = Integer.parseInt(scanner.nextLine());
		Simulation simulation = new Simulation(times);

		simulation.prepareFile();
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			simulation.addFlyable(line);
		}
		scanner.close();
		return simulation;
	}
}
