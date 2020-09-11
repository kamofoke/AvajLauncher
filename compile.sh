find -name *.java > sources.txt
javac -sourcepath . @sources.txt
cd src/
java kamofoke.tower.Takeoff scenario.txt
