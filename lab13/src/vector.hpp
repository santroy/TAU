#ifndef __VECTOR_HPP__
#define __VECTOR_HPP__
#include <vector>

class Vector { 

    private:
        std::vector <int> params;
        void printVector (int i);
    public:
        void addPoint(int point);
        void add(Vector vectorToAdd);
        void subtract(Vector vectorToAdd);
        void multiply(Vector vectorToAdd);
        void print();
        bool equals(Vector vectorToCompare);
};


#endif // __WEKTOR_HPP__