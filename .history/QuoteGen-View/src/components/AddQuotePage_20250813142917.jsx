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
        <h1>En</h1>
    </form>
  </div>;
};

export default AddQuotePage;
