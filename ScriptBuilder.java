import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;
class ScriptBuilder {
		static String output="";
		static int quality = 75;
		static boolean lossless = false;
		static boolean overwrite = false;
		static int index = 0;
		public static void main(String []args){
			Scanner input = new Scanner( System.in ); 
			System.out.println( "Specify the compression factor between 0 and 100. A small factor produces smaller file with lower quality. Best quality is achieved using a value of 100. The default is 75.\n\nInput must be an integer between 0 and 100: " );
			quality = input.nextInt();
			System.out.println("Lossless compression? (y/n)");
			String c = input.next();
			if (c.toLowerCase().charAt(0) == 'y'){
				lossless = true;
			}
			System.out.println("Overwrite if output file already exists? (y/n)");
			c = input.next();
			if (c.toLowerCase().charAt(0) == 'y'){
				overwrite = true;
			}
			try {
				getFiles("./input/");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*Missing
		 * Birthdays: 3-23, 6-29
		 * Events: 3-24
		 */
		static void getFiles(String location) throws IOException{
			
		 File f = new File(location);

		    FilenameFilter textFilter = new FilenameFilter() {
		        public boolean accept(File dir, String name) {
		            String lowercaseName = name.toLowerCase();
		            if (lowercaseName.endsWith(".jpg") || lowercaseName.endsWith(".png") || lowercaseName.endsWith(".tiff")) {
		                return true;
		            } else {
		                return false;
		            }
		        }
		    };

		    File[] files = f.listFiles(textFilter);
		    System.out.println("Total number of files found:"+files.length);
		    for (File file : files) {
		        if (file.isDirectory()) {
		            System.out.print("directory:");
		        } else {
						checkFile(file);
		        }
		    }

		    writeToFile(output,"./","curlscript");
		}
		static void checkFile(File file) throws FileNotFoundException{
			String name = file.getName();
			System.out.println("File #"+index+" -"+name);
			name = name.replaceAll(".jpg", "");
			String directory = file.getAbsolutePath();
			String[] directorysplit = directory.split("/./");
			directory = directorysplit[0];
			File f = new File(directory+"/output/"+name+".webp");
			if(!f.exists()){
			String losslessString = "";
			if (lossless){
				losslessString = "-lossless ";
			}
			
			String script = directory+"/cwebp "+losslessString+"input/"+name+".jpg -q 80 -o output/"+name+".webp";
			output=output+script+"\n";
			}
			index++;
		}
		
		public static void writeToFile(String data, String folder,String file) throws IOException {
	        FileWriter fstream = null;


	        try {
	            fstream = new FileWriter(folder+file);
	            BufferedWriter out = new BufferedWriter(fstream);
	            out.write(data);
	            //Close the output stream
	            out.close();
	        } catch (IOException ex) {
	        } finally {
	            try {
	                fstream.close();
	            } catch (Exception ex) {
	            	System.out.println("Error trying to create:"+file);
	            	ex.printStackTrace();
	            }
	        }
	    }
}
