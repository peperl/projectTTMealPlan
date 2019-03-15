#include <jni.h>
#include <stdio.h>
#include "BinarySelection.h"

//gcc -o libBinarySelection.so BinarySelection.c -shared -I/usr/local/java/jdk1.8.0_161/include -I/usr/local/java/jdk1.8.0_161/include/linux

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

JNIEXPORT jint JNICALL Java_mx_ipn_www_finalproject_utils_BinarySelection_cross
  (JNIEnv *env, jobject obj, jint mealIdj, jint mealIdj2) {
	unsigned int mealId = (unsigned int) mealIdj;
	unsigned int mealId2 = (unsigned int) mealIdj2;
	mealId = mealId >> 18;
	mealId = mealId << 18;
	mealId2 = mealId2 << 14;
	mealId2 = mealId2 >> 14;
	return mealId + mealId2;
  }

JNIEXPORT jint JNICALL Java_mx_ipn_www_finalproject_utils_BinarySelection_mutation
  (JNIEnv *env, jobject obj, jint mealIdj, jint foodLocationj) {
  	unsigned int mealId = (unsigned int) mealIdj;
  	int foodLocation = (int) foodLocationj;
	int i = 1 << 28 - foodLocation * 6;
  	mealId = mealId + i;
  	return mealId;
  }