#include <jni.h>
#include <stdio.h>
#include "BinarySelection.h"

/**
	Se tendrá acceso solo a 5 alimentos, por lo que foodLocation será de 0-4
*/
JNIEXPORT jint JNICALL Java_mx_ipn_www_finalproject_utils_BinarySelection_getAlimento
  (JNIEnv *env, jobject obj, jint mealIdj, jint foodLocationj) {
  	unsigned int mealId = (unsigned int) mealIdj;
  	int foodLocation = (int) foodLocationj;
	int initialMove = 2 + 6 * foodLocation;
	mealId = mealId << initialMove;
	mealId = mealId >> 26;
	return (mealId & 15) + 1 ;
  }

JNIEXPORT jint JNICALL Java_mx_ipn_www_finalproject_utils_BinarySelection_getCantidad
  (JNIEnv *env, jobject obj, jint mealIdj, jint foodLocationj) {
  	unsigned int mealId = (unsigned int) mealIdj;
  	int foodLocation = (int) foodLocationj;
	int initialMove = 2 + 6 * foodLocation;
	mealId = mealId << initialMove;
	mealId = mealId >> 26 + 4;
	return mealId + 1;
  }
