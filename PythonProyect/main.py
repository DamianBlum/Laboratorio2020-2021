# This is a sample Python script.

# Press Mayús+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
import pandas as pd


def print_hi(name):
    df = pd.read_csv("delitos_2020.csv")  # Punto 1
    # df = df.set_index('id_mapa')  # Punto 2, no puedo indexarlo asi que lo dejo comentado
    df = df.drop_duplicates()  # Punto 3
    # df.dropna() # Punto 5 como siempre hay algun NaT lo tengo como comentar
    df1 = df.loc[0:3000]  # Punto 6
    df2 = df.loc[64718:66718]  # Punto 6
    df3 = df1.append(df2)  # Punto 6
    df3.to_csv("prueba.csv")  # Punto 7

    # print(list(df.columns))   muestra nombres de la columnas en una linea, id anio mes dia fecha franja etc
    # print(list(df.index)) muestra cuantas horizontales hay
    # df.loc[0:1000] imprime solo las primeras 1000 filas, hay un inicio y un fin
    # df['sexo'].value_counts()
    # df.dropna(inplace=True)
    # dfConIndiceDni = df.set_index('mes') # setea un indice se basa en eso para recorre?, ignora el mes?
    # dfSinFilasConNan = df.dropna() # eliminar filas
    print(df3)


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print_hi('PyCharm')

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
