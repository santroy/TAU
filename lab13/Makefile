

all: build/vector.o

build/vector.o: src/vector.cpp
	g++ -std=c++11 -c src/vector.cpp -o build/vector.o

tests: unit
	./unit -r junit
	./unit -s

unit: build/unit_vector.o build/units.o build/vector.o
	g++ build/unit_vector.o build/units.o build/vector.o -o unit


build/units.o: src/tests/units.cpp
	g++ -std=c++11 -Isrc -Ithirdparty -c src/tests/units.cpp -o build/units.o

build/unit_vector.o: src/tests/unit_vector.cpp
	g++ -std=c++11 -Isrc -Ithirdparty  -c src/tests/unit_vector.cpp -o build/unit_vector.o

clean:
	rm -f build/*.o unit

