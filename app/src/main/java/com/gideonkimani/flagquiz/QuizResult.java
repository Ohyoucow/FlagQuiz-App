package com.gideonkimani.flagquiz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

public class QuizResult extends DialogFragment {

    public Dialog onCreateDialog(Bundle bundle) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final MainActivityFragment quizFragment = getQuizFragment();

        builder.setMessage(getString(R.string.results, quizFragment.totalGuesses, (1000 / (double) quizFragment.totalGuesses)));

        builder.setPositiveButton(R.string.reset_quiz,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        quizFragment.resetQuiz();

                    }
                }

        );
        return builder.create();
    }

    private MainActivityFragment getQuizFragment() {
        MainActivityFragment quizFragment = MainActivity.result;
        return quizFragment;
    }
}
