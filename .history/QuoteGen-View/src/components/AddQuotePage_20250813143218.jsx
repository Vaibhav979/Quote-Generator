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
        <input {...register("quote"),
            { required: true, maxLength: 1000, minLength: 10 },
             pattern: {
                  value: /^[A-Za-z]+$/i,
                  message: "Only alphabets are allowed",
                },
        }/>
    </form>
  </div>;
};

export default AddQuotePage;
