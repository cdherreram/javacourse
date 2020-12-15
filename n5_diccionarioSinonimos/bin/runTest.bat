@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n
REM Licenciado bajo el esquema Academic Free License version 2.1
REM
REM Proyecto Cupi2
REM Ejercicio: n5_diccionarioSinonimos
REM Autor: Mario S�nchez - 12-Jul-2005
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM/


REM ---------------------------------------------------------
REM Ejecucion de la prueba
REM ---------------------------------------------------------

cd ..
java -classpath ./lib/sinonimos.jar;./test/lib/sinonimosTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.sinonimos.test.DiccionarioTest
java -classpath ./lib/sinonimos.jar;./test/lib/sinonimosTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.sinonimos.test.PalabraTest
cd bin