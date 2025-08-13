import React from "react";
import { useForm } from "react-hook-form";

const AddQuotePage = () => {
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors, isSubmitting },
  } = useForm();
  return <div>
    <form onSubmit={handleSubmit(onSubmit)}>
        <h1>Enter your quote!</h1>
        <label> Quote: </label>
        <input {...register("quote", 
            { required: true,
                minLength: {
                    value: 5,
                    message: "Quote must be at least 5 characters long",
                },
                maxLength: {
                    value: 500,
                    message: "Quote must be less than 500 characters",
                }
             }
        )}/>
    </form>
  </div>;
};

export default AddQuotePage;
