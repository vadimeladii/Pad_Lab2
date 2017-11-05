module common {
    requires jackson.databind;
    requires jackson.core;
    exports md.utm.fcim.repository;
    exports md.utm.fcim.repository.impl;
    exports md.utm.fcim.dto;
}