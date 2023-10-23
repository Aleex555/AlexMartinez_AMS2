using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerState : MonoBehaviour
{
    Animator animator;
    public LayerMask Ground;
    public float castDistance;
    public float airFriction = 3.0f;
    public float groundFriction = 3.0f;
    public float speed = 0.3f;
    private Rigidbody2D rb;
    private SpriteRenderer flip1;
    public Vector2 boxSize;
    // Start is called before the first frame update
    void Start()
    {
        rb = GetComponent<Rigidbody2D>();
        animator = GetComponent<Animator>();
        flip1 = GetComponent<SpriteRenderer>();

    }

    // Update is called once per frame
    void Update(){   
        
        float horizontalInput = Input.GetAxis("Horizontal");
        float verticalInput = Input.GetAxis("Vertical");
        //Vector2 direction = new Vector2(horizontalInput, verticalInput);
        //transform.Translate(direction * speed * Time.deltaTime);
        ApplyFriction();
        if (horizontalInput > 0)
        {
            flip1.flipX = false;
            rb.AddForce(new Vector2(1000f*Time.deltaTime,0));
            animator.SetBool("Walking", true);
        }
        else if (horizontalInput<0)
        {   flip1.flipX = true;
            rb.AddForce(new Vector2(-1000f*Time.deltaTime,0));
            animator.SetBool("Walking", true);
        }else{
            animator.SetBool("Walking",false);
        }
        if (verticalInput>0)
        {
            rb.AddForce(new Vector2(0,1000f*Time.deltaTime));
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

    void ApplyFriction()
    {
        float friction = isGrounded() ? groundFriction : airFriction;
        rb.velocity = new Vector2(rb.velocity.x * (1 - friction * Time.deltaTime), rb.velocity.y);
    }

    public bool isGrounded()
    {
        if (Physics2D.BoxCast(transform.position, boxSize, 0, -transform.up, castDistance, Ground))
        {
            return true;
        }
        return false;
    }
}
