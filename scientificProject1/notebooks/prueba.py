import seaborn as sns
import pandas as pd

df=pd.read_csv("/home/damian/Desktop/Laboratorio/scientificProject1/data/Analisis taller de soporte informático.csv")
df2= df[["¿Cuánto te gusta Python como lenguaje de programación?", "¿Hasta qué mes entregaste trabajos?", "¿Considerás que analizar datos es aburrido?"]]

#change ¿Cuánto te gusta Python como lenguaje de programación? to 1-5 range
df2["¿Cuánto te gusta Python como lenguaje de programación?"] = df2["¿Cuánto te gusta Python como lenguaje de programación?"].replace(["Nada","Un poco","Normal","Bastante","Me encanta"], [1,2,3,4,5])
#change ¿Considerás que analizar datos es aburrido? to 1-5 range
df2["¿Considerás que analizar datos es aburrido?"] = df2["¿Considerás que analizar datos es aburrido?"].replace(["Si","No"], [1,2])

df2=df2.drop(df2[df2["¿Cuánto te gusta Python como lenguaje de programación?"]=="me fascina"].index)
df2
sns.pairplot(df2,hue="¿Hasta qué mes entregaste trabajos?",palette="Spectral")
