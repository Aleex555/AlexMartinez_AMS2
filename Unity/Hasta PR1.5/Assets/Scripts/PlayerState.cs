using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerState : MonoBehaviour
{
    Animator animator;
    public float speed = 0.3f;
    private Rigidbody rb;
    private SpriteRenderer flip1;
    // Start is called before the first frame update
    void Start()
    {
        rb = GetComponent<Rigidbody>();
        animator = GetComponent<Animator>();
        flip1 = GetComponent<SpriteRenderer>();

    }

    // Update is called once per frame
    void Update()
    {
        float horizontalInput = Input.GetAxis("Horizontal");
        float verticalInput = Input.GetAxis("Vertical");
        Vector2 direction = new Vector2(horizontalInput, verticalInput);
        transform.Translate(direction * speed * Time.deltaTime);
        if (horizontalInput > 0)
        {
            flip1.flipX = false;
            animator.SetBool("Walking", true);
        }
        else if (horizontalInput<0)
        {   flip1.flipX = true;
            animator.SetBool("Walking", true);
        }else{
            animator.SetBool("Walking",false);
        }
        if (verticalInput>0)
        {
            animator.SetBool("isJumping",true);
        }else{
            animator.SetBool("isJumping",false);
        }
        if(verticalInput<0){
            animator.SetBool("isCrouching",true);
        }else{
            animator.SetBool("isCrouching",false);
        }

    }
}
