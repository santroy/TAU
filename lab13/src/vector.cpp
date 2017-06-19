#include "vector.hpp" 
#include <iostream>
#include <vector>
#include <algorithm>
using std::vector;
using std::cout;
using std::mem_fun;
using std::bind1st;
using std::for_each;
using std::invalid_argument; 

        void Vector::printVector(int i) {  // function:
            cout << ' ' << i;
        }
    
        void Vector::addPoint(int point) {
            this->params.push_back(point);
        }

        void Vector::add(Vector vectorToAdd) {
            
            if(this->params.size() != vectorToAdd.params.size()) 
                throw invalid_argument("Vectors length are not equal!");

            for( int i = 0; i < this->params.size(); i++ ) {
                this->params[i] = this->params[i] + vectorToAdd.params[i];
            }
        }

        void Vector::subtract(Vector vectorToSubtract) {
            
            if(this->params.size() != vectorToSubtract.params.size()) 
                throw invalid_argument("Vectors length are not equal!");

            for( int i = 0; i < this->params.size(); i++ ) {
                this->params[i] = this->params[i] - vectorToSubtract.params[i];
            }
        }

        void Vector::multiply(Vector vectorToMultiply) {
            
            if(this->params.size() != vectorToMultiply.params.size()) 
                throw invalid_argument("Vectors length are not equal!");

            for( int i = 0; i < this->params.size(); i++ ) {
                this->params[i] = this->params[i] * vectorToMultiply.params[i];
            }
        }

        void Vector::print() {
            for_each(this->params.begin(), this->params.end(), bind1st(mem_fun(&Vector::printVector), this));
        }

        bool Vector::equals(Vector vectorToCompare) {
            if(this->params.size() != vectorToCompare.params.size()) 
                throw invalid_argument("Vectors length are not equal!");

            for( int i = 0; i < this->params.size(); i++ ) {
                if(this->params[i] != vectorToCompare.params[i]) {
                    return false;
                }   
            }
            return true;
        }
