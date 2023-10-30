using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class spawner : MonoBehaviour
{
    float timer;
    float interval = 1f;
    public GameObject gearPreFab;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update(){
        timer += Time.deltaTime;
        if (timer >= interval)
        {

            timer = 0f;

            if (gearPreFab != null)
            {
                float randomX = Random.Range(-10, 10f);
                float randomY = Random.Range(0, 3);
                Vector3 randomPosition = new Vector3(randomX, randomY, 0f);
                Instantiate(gearPreFab, transform.position, Quaternion.identity);
            }
    }
    }
    
}