#Criação de associaco entre palavra de origem producao 
CREATE TABLE pg_midia_social (
  id int(11) NOT NULL AUTO_INCREMENT,
  txt_tweet varchar(600),
  txt_tweet_tag varchar(800),
  dta_completa date,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=933377 DEFAULT CHARSET=utf8;


CREATE TABLE midia_social_origem (
  idorigem int(11) NOT NULL AUTO_INCREMENT,
  titulo text NOT NULL,
  id_original int(11) NOT NULL,
  id_area_conhecimento varchar(45) NOT NULL,
  PRIMARY KEY (idorigem)
) ENGINE=MyISAM AUTO_INCREMENT=1493452 DEFAULT CHARSET=utf8;
ALTER TABLE  midia_social_origem ADD INDEX ob_id_original (id_original) USING BTREE;

CREATE TABLE midia_social_origem_has_palavra (
  idorigem_has_palavra int(11) NOT NULL AUTO_INCREMENT,
  idpalavra int(11) NOT NULL,
  idorigem int(11) NOT NULL,
  PRIMARY KEY (`idorigem_has_palavra`)
) ENGINE=MyISAM AUTO_INCREMENT=56094 DEFAULT CHARSET=utf8;

ALTER TABLE  midia_social_origem_has_palavra ADD INDEX mshpb_idpalavra(idpalavra) USING BTREE;
ALTER TABLE  midia_social_origem_has_palavra ADD INDEX mshpb_idorigem(idorigem) USING BTREE;

CREATE TABLE midia_social_radical (
  idstem int(11) NOT NULL AUTO_INCREMENT,
  stem varchar(200) NOT NULL,
  qtd_stem int(11) NOT NULL,
  PRIMARY KEY (`idstem`),
  UNIQUE KEY `stem_UNIQUE` (`stem`)
) ENGINE=MyISAM AUTO_INCREMENT=25955 DEFAULT CHARSET=utf8;


CREATE TABLE midia_social_palavras (
  idpalavras  int(11) NOT NULL AUTO_INCREMENT,
  palavra    varchar(200) NOT NULL,
  qtd_word   int(11) NOT NULL,
  idstem     int(11) DEFAULT NULL,
  tipo       varchar(45) NOT NULL,
  PRIMARY KEY (idpalavras)
) ENGINE=MyISAM AUTO_INCREMENT=12482 DEFAULT CHARSET=utf8;
ALTER TABLE  midia_social_palavras ADD INDEX msp_idstem(idstem) USING BTREE;
ALTER TABLE  midia_social_palavras ADD INDEX msp_tipo(tipo) USING BTREE;
ALTER TABLE  midia_social_palavras ADD UNIQUE unique_index(palavra,tipo);

