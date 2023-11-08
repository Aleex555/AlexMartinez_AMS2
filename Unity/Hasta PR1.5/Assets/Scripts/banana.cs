using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class banana : MonoBehaviour
{
    public spawner spawnerReference; // Referencia al spawner que instancia este objeto.

    private void OnTriggerEnter2D(Collider2D object1)
    {
        if (object1.CompareTag("Player"))
        {
            Debug.Log("Gotcha");
            if (spawnerReference != null)
            {
                spawnerReference.DecrementObjectCount(); // Notifica al spawner que el objeto ha sido destruido.
            }
            Destroy(gameObject);
        }
    }

    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
    }
}
