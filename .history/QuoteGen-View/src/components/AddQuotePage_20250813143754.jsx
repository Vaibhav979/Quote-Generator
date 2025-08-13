import React from "react";
import { useForm } from "react-hook-form";

const AddQuotePage = () => {
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors, isSubmitting },
  } = useForm();

  async 
  return (
    <div>
      <form onSubmit={handleSubmit(onSubmit)}>
        <h1>Enter your quote!</h1>
        <label> Quote: </label>
        <input
          {...register("quote", {
            required: true,
            minLength: {
              value: 5,
              message: "Quote must be at least 5 characters long",
            },
            maxLength: {
              value: 500,
            },
            pattern: {
              value: /^[a-zA-Z0-9\s.,!?'"-]+$/,
              message:
                "Quote can only contain letters, numbers, and basic punctuation.",
            },
          })}
        />
        {errors.quote && <p style={{ color: "red" }}>{errors.quote.message}</p>}
        <br />
      </form>
    </div>
  );
};

export default AddQuotePage;
