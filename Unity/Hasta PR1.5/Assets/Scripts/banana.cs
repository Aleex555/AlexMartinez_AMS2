using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class banana : MonoBehaviour
{
    private void OnTriggerEnter2D(Collider2D object1){
        if (object1.CompareTag("Player")) // Puedes reemplazar "Player" con la etiqueta correcta del objeto con el que colisionas.
        {
            Debug.Log("Gotcha");
            Destroy(gameObject);
        }
    }
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update(){
    }
}
