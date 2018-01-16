package nyc.c4q.mustafizurmatin.midtermretake;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LoopActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);
        //textView = (TextView) findViewById(R.id.splas_textview);
        Task task = new Task(this);
        task.execute(0);
    }



    private class Task extends AsyncTask<Integer, Integer, Integer> {
        private Activity activity;

        public Task(Activity activity) {
            this.activity = activity;
        }

        @Override
        protected void onPreExecute() {
            //Setup precondition to execute some task
        }

        @Override
        protected Integer doInBackground(Integer[] objects) {

            int i;
            for (i = objects[0]; i < 100000; i++) {
                publishProgress(i);
            }
            return i;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            textView.setText("Loops completed: " + values[0]);
        }

        @Override
        protected void onPostExecute(Integer o) {
            super.onPostExecute(o);
            textView.setText("Loops completed: " + o);

            Intent intent = new Intent(LoopActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

}
