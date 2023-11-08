using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class spawner : MonoBehaviour
{
    float timer;
    float interval = 1f;
    public GameObject gearPreFab;
    int numberOfObjectsToInstantiate = 0; // Variable para llevar un seguimiento del número de objetos instanciados.

    // Start is called before the first frame update
    void Start()
    {
        // Puedes inicializar numberOfObjectsToInstantiate aquí si quieres empezar con un número inicial de objetos.
    }

    // Update is called once per frame
    void Update()
    {
        timer += Time.deltaTime;
        if (timer >= interval)
        {
            timer = 0f;

            if (numberOfObjectsToInstantiate < 10) // Verifica que no hayas alcanzado el límite de 10 objetos.
            {
                float randomX = Random.Range(-10f, 10f);
                float randomY = Random.Range(0f, 3f);
                Vector3 randomPosition = new Vector3(randomX, randomY, 0f);
                GameObject newGear = Instantiate(gearPreFab, randomPosition, Quaternion.identity);
                numberOfObjectsToInstantiate++; // Aumenta la cuenta de objetos instanciados.
                newGear.GetComponent<banana>().spawnerReference = this; // Asigna una referencia al spawner al objeto "banana".
            }
        }
    }

    // Método para disminuir el contador de objetos instanciados cuando "banana" destruye un objeto.
    public void DecrementObjectCount()
    {
        numberOfObjectsToInstantiate--;
    }
}
