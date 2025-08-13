import React from "react";
import { useForm } from "react-hook-form";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const AddQuotePage = () => {
  const {
    register,
    handleSubmit,
    reset
    watch,
    formState: { errors, isSubmitting },
  } = useForm();

  async function onSubmit(data) {
    await new Promise((resolve) => setTimeout(resolve, 2000));
    try {
      const response = await fetch("http://localhost:8080/addQuote", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ quote: data.quote }),
      });
      const message = await response.text();
      if (response.ok) {
        toast.success("Quote added successfully!");
        reset(); // clears the input field after submission
      }
    } catch (error) {
      toast.error("Something went wrong. Please try again.");
    }
  }

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
        <input
          type="submit"
          disabled={isSubmitting}
          value={isSubmitting ? "Submitting..." : "Submit Quote"}
        />
      </form>
      <ToastContainer position="top-center" autoClose={3000} />
    </div>
  );
};

export default AddQuotePage;
