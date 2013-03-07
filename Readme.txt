Note: The project has only been tested on Mac OS X Lion. If it works fine on other platforms, please do let me know on Twitter (@raveeshbhalla)

This script helps encode multiple .jpeg, .png and .tiff files to .webp in one go, instead of individual lines of script for each image.

Steps: 
1. Download the Precompiled WebP utilities and library from the following link - https://developers.google.com/speed/webp/download
2. Extract the downloaded file from Step 1.
3. Place the contents of this library (i.e. ScriptBuilder.java, the convertscript file and the input and output folders) in the root of the extracted folder.
4. Open up Terminal and go to the root of the folder extracted in Step 2.
5. (Required only on the first run) Make convertscript executable by entering the following in the terminal
chmod 755 convertscript
6. Create two folders in the root of the folder extracted in Step 2. Name them "input" and "output".
7. Place all the images you want to be converted to .webp in the input folder.
8. To run the script, simply enter "./convertscript"
9. The process can take a while, depending on the number of images. After entering the required parameters in the beginning (3 of them) you can let it run in the background.

Thanks to:
mkrishnan from MacRumors forum, from where I learnt how to batch execution of commands is possible in Terminal
http://forums.macrumors.com/showpost.php?p=1454065&postcount=3