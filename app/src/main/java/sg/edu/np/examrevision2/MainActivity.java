package sg.edu.np.examrevision2;

import android.animation.RectEvaluator;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyDBHandler db = new MyDBHandler(this, null, null, 1);
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button add = findViewById(R.id.clickMeBaby);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                showNoteDialog();
            }
        });

        showAllNotes();
    }

    public void showAllNotes()
    {
        RecyclerView rv = findViewById(R.id.rv);
        ArrayList<String> notes = db.getAllNotes();

        NoteAdapter noteAdapter = new NoteAdapter(this, notes);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setLayoutManager(layout);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(noteAdapter);
    }

    public void showNoteDialog()
    {
        View v = View.inflate(this, R.layout.notedialog, null);
        editText = v.findViewById(R.id.etNote);

        new AlertDialog.Builder(MainActivity.this).setTitle("Add a new note").setView(v)
                .setPositiveButton("Add", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        db.addNote(editText.getText().toString());
                        showAllNotes();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                })
                .show();
    }

}
