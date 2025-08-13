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
        <input {...register("quote")}/>
    </form>
  </div>;
};

export default AddQuotePage;
