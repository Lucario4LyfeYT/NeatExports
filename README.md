# NeatExports

VRCHAT

Make exported avatar lists look neat

This application only supports Exported Avatar Lists from these mods

https://emmvrc.com/

https://github.com/notunixian/odious

https://github.com/FelkonEx/FavCat-Restored

This is useful if you're sending exported avatars to people through discord and you don't want to spend time manually editing the export file to look neat

1.) Name the exported EMM file to "EMM.txt" (without quotes)

1.) Name the exported ODIOUS file to "ODIOUS.txt" (without quotes)

1.) Name the exported FavCatRestored file to "FavCatRestored.txt" (without quotes)

2.) Put "EMM.txt" in same folder as "export 1.1.jar"

2.) Put "ODIOUS.txt" in same folder as "export 1.1.jar"

2.) Put "FavCatRestored.txt" in same folder as "export 1.1.jar"

3.) Goto https://r12a.github.io/app-conversion/ if you're using "FavCatRestored.txt" and convert it to js with these settings
![Settings](https://user-images.githubusercontent.com/86382621/164874131-dfcc7a66-dc77-4f7d-8f95-d9ab9178ebb0.PNG)
then copy-paste the converted text to your "FavCatRestored.txt" and it'll fix every issue with unicode characters crashing the jar file, or you could build from the source and run it in a java IDE like blueJ or Eclipse or something and that'll work without the need to convert the text.

Once your txt file(s) are in the same folder as "ExportEmmOdiousToReadable.jar", open "ExportEmmOdiousToReadable.jar" and boom, neat avatars

Source code is in Src if any of you guys are scared to run it :)
