INSERT INTO `finance_service` (`code`, `description`, `rule_set`)
    VALUES ('CAH', 'Cuenta de ahorros', '{"countries": ["CO"], "minAge": 18,"minIncome": 0.0}');
INSERT INTO `finance_service` (`code`, `description`, `rule_set`)
    VALUES ('TDB', 'Tarjeta débito', '{"countries": ["CO"], "minAge": 18,"minIncome": 1300000.0}');
INSERT INTO `finance_service` (`code`, `description`, `rule_set`)
    VALUES ('TDC', 'Tarjeta de crédito', '{"countries": ["CO"], "minAge": 20,"minIncome": 2500000.0}');
INSERT INTO `finance_service` (`code`, `description`, `rule_set`)
    VALUES ('SEG', 'Seguro', '{"countries": [], "minAge": 15,"minIncome": 800000.0}');
INSERT INTO `finance_service` (`code`, `description`, `rule_set`)
    VALUES ('INV', 'Inversión', '{"countries": [], "minAge": 25,"minIncome": 4500000.0}');
INSERT INTO `finance_service` (`code`, `description`, `rule_set`)
    VALUES ('GIR', 'Giro', '{"countries": ["CO", "PE", "EC", "PA"], "minAge": 0,"minIncome": 0.0}');
INSERT INTO `finance_service` (`code`, `description`, `rule_set`)
    VALUES ('TAM', 'Tarjeta amparada', '{"countries": [], "minAge": 15,"minIncome": 0.0}');