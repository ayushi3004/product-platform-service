package com.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Service
public class CommentValidationService {
  static Map<String, Double> wordMap = new HashMap<>();
  static final Double SCORE_THRESHOLD = 0.472;

  public CommentValidationService() throws Exception {
    loadFile();
  }

  void loadFile() throws Exception {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("hateSpeech.csv").getFile());
    FileReader fr = new FileReader(file);
    BufferedReader br = new BufferedReader(fr);
    String line;
    String cvsSplitBy = ",";

    while ((line = br.readLine()) != null) {
      String[] wordNscore = line.split(cvsSplitBy);
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
