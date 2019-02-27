package com.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Service
public class CommentValidationService {
  static final Double SCORE_THRESHOLD = 0.472;
  static Map<String, Double> wordMap = new HashMap<>();

  public CommentValidationService() throws Exception {
    loadFile();
  }

  void loadFile() throws Exception {
    InputStream is = getClass().getResourceAsStream("/hateSpeech.csv");
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    String line;
    String csvSplitBy = ",";

    while ((line = br.readLine()) != null) {
      String[] wordNscore = line.split(csvSplitBy);
      wordMap.put(wordNscore[0], Double.parseDouble(wordNscore[1]));
    }
  }

  public boolean validateComment(String comment) {
    String[] tokens = comment.split(" ");
    Double confidence;
    for (String token : tokens) {
      confidence = wordMap.getOrDefault(token, 0.0);
      if (confidence >= SCORE_THRESHOLD) return false;
    }
    return true;
  }
}
